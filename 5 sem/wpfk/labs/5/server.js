require('reflect-metadata');
const pug = require('pug');
const express = require('express');
const { createConnection } = require('typeorm');
const { Parser } = require('../1/shared');
const Student = require('./entity/Student');
const app = express();

const root = process.cwd() + '/pages';

let connection;


createConnection({
  type: 'sqlite',
  synchronize: true,
  database: 'datavase.sqlite',
  entities: [
    __dirname + '/entity/*.ts'
  ]
})
  .then(conn => { connection = conn; })
  .catch(err => console.log("Error ", err))


app.use(express.static('static'));
app.use(express.json())

app.get('/', (req, res) => {
  const compiled = pug.compileFile('pages/index.pug');
  res.send(compiled());
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
  const compiled = pug.compileFile('pages/about.pug');
  res.send(compiled());
});

app.get('/table', (req, res) => {
  const compiled = pug.compileFile('pages/table.pug');
  res.send(compiled());
});

app.get('/api/getStudents', (req, res) => {
  res.setHeader('Content-Type', 'application/json');

  const StudentRepository = connection.getRepository(Student);

  StudentRepository.find().then((loadedStudents) => {
    const response = [];

    for (let i = 0; i < loadedStudents.length; i += 1) {
      const st = loadedStudents[i];

      response.push({
        id: st.id,
        name: st.name,
        city: st.city,
        birthday: st.birthday,
      })
    }

    res.send({ students: response });
  })
    .catch((err) => {
      console.log('Error: ', err);
      res.statusCode = 500;
      res.send('');
    });
});

app.get('/api/getStudents/html', (req, res) => {
  const compiled = pug.compileFile('pages/students-in-table.pug');

  const StudentRepository = connection.getRepository(Student);

  StudentRepository.find().then((loadedStudents) => {
    const response = [];

    for (let i = 0; i < loadedStudents.length; i += 1) {
      const st = loadedStudents[i];

      response.push({
        id: st.id,
        name: st.name,
        city: st.city,
        birthday: st.birthday,
      })
    }

    res.send(compiled({ students: response }));
  })
    .catch((err) => {
      console.log('Error: ', err);
      res.statusCode = 500;
      res.send('');
    });
});

app.post('/api/addStudent', (req, res) => {
  res.setHeader('Content-Type', '/application/json');

  const StudentRepository = connection.getRepository(Student);

  const st = new Student();

  st.name = req.body.name;
  st.birthday = req.body.birthday;
  st.city = req.body.city;

  StudentRepository
    .save(st)
    .then((student) => res.send({ id: student.id }))
    .catch((err) => {
      console.log('Error; ', err);
      res.statusCode = 500;
      res.send('');
    })
});

app.post('/api/removeStudent', (req, res) => {
  const StudentRepository = connection.getRepository(Student);

  StudentRepository.findOne(req.body.id)
    .then((st) => StudentRepository.remove(st))
    .then(() => res.send('OK'))
    .catch((err) => {
      console.log('Error; ', err);
      res.statusCode = 500;
      res.send('');
    });
});

app.post('/api/updateStudent', (req, res) => {
  const StudentRepository = connection.getRepository(Student);

  const st = new Student();

  StudentRepository.findOne(req.body.id).then((st) => {
    st.name = req.body.name;
    st.birthday = req.body.birthday;
    st.city = req.body.city;
    return StudentRepository.save(st);
  })
    .then(() => res.send('OK'))
    .catch((err) => {
      console.log('Error; ', err);
      res.statusCode = 500;
      res.send('');
    });
});

app.listen(8080, () => {
  console.log('Server listening on port 8080');
});
