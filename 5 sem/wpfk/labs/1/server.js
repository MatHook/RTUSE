const net = require('net');
const { Parser } = require('./shared');

const HOST = '0.0.0.0';
const PORT = '12345';

net.createServer((sock) => {
  console.log('CONNECTED: ' + sock.remoteAddress + ':' + sock.remotePort);

  sock.on('data', (data) => {
    console.log('DATA ' + sock.remoteAddress + ': ' + data);

    const pars = Parser.deserialize(JSON.parse(data.toString()));

    sock.write('' + pars.getResult());
  });

  sock.on('close', () => {
    console.log('CLOSED: ' + sock.remoteAddress + ':' + sock.remotePort)
  })
}).listen(PORT, HOST);

console.log('Server listening on ' + HOST + ':' + PORT);
