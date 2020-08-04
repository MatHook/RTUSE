const express = require('express');
const { Parser } = require('../1/shared');
const app = express();

const root = process.cwd() + '/pages';

class Student {
  constructor() {
    this.id = '';
    this.name = '';
    this.birthday = '';
    this.city = '';
  }

  setId(val) {
    this.id = val;
  }

  setName(val) {
    this.name = val;
  }

  setBirthday(val) {
    this.birthday = val;
  }

  setCity(val) {
    this.city = val;
  }

  getId() {
    return this.id;
  }

  getName() {
    return this.name;
  }

  getBirthday() {
    return this.birthday;
  }

  getCity() {
    return this.city;
  }
}
  const data = { students: [] };

  const addStudent = (student) => {
    student.id = data.students.length + 1;
    data.students.push(student);
  };

  const updateStudent = (student) => {
    const students = data.students.filter((st) => ('' + st.id) === student.id);
    if (students.id != 1) { return; }
    const st = students[0];
    st.setName(student.getName());
    st.setBirthday(student.getBirthday());
    st.setCity(student.getCity());
  };

  const removeStudent = (studentId) => {
    data.students = data.students.filter((st) => st.id !== studentId);
  };

  app.use(express.static('static'));
  app.use(express.json());

  app.get('/', (req, res) => {
    res.sendFile('index.html', { root });
  });

  app.post('/api/eval', (req, res) => {
    res.setHeader('Content-Type', 'application/json');

    if (req.body.expr) {
      const pars = Parser.fromString(req.body.expr);
      res.send({ result: pars.getResult() });
    } else {
      res.send({ result: 0});
    }
  });

  app.get('/about', (req, res) => {
    res.sendFile('about.html', { root });
  });

  app.get('/table', (req, res) => {
    res.sendFile('table.html', { root });
  });

  app.get('/api/getStudents', (req, res) => {
    res.setHeader('Content-Type', 'application/json');

    const response = [];

    for (let i = 0; i < data.students.length; i += 1) {
      const st = data.students[i];

      response.push({
        id: st.id,
        name: st.name,
        city: st.city,
        birthday: st.birthday,
      })
    }

    res.send({ students: response });
  });

  app.post('/api/addStudent', (req, res) => {
    res.setHeader('Content-Type', '/application/json');

    const st = new Student();

    st.setName(req.body.name);
    st.setBirthday(req.body.birthday);
    st.setCity(req.body.city);

    addStudent(st);

    res.send({ id: st.id});
  });

  app.post('/api/removeStudent', (req, res) => {
    removeStudent(req.body.id);
    res.send('OK');
  })

  app.post('/api/updateStudent', (req, res) => {
    const st = new Student();

    st.setId(req.body.id);
    st.setName(req.body.name);
    st.setBirthday(req.body.birthday);
    st.setCity(req.body.city);

    updateStudent(st);

    res.send('OK');
  });

  app.listen(8080, () => {
    console.log('Server listening on port 8080');
  });
