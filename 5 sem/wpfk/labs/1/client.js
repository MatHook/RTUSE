const net = require('net');
const readline = require('readline');
const { Parser } = require('./shared');

conn = net.connect({
  host: '0.0.0.0',
  port: '12345',
});

conn.on('data', (data) => {
  console.log('Recived: ' + data);
});

const inter = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

inter.on('line', (line) => {
  conn.write(Parser.fromString(line).serialize());
});
