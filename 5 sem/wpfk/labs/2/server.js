const http = require('http');
const { Parser } = require('../1/shared');

const PORT = 8080;
const HOST = '0.0.0.0';

const server = http.createServer((request, response) => {
  if (request.method === 'GET') {
    response.setHeader('Content-Type', 'text/html');

    if (!request.url.startsWith('/?expr=')) {
      response.end(`
                <html>
                    <body>
                        <form method="get">
                            <input name="expr" />
                            <button type="submit">Let's go</button>
                        </form>
                    </body>
                </html>
            `);
      return;
    }

    const pars = Parser.fromString(
      decodeURIComponent(request.url.slice(7).replace(/\+/g, ' '))
    );

    response.end(`
            <html>
                <meta charset="UTF-8">
                <body>
                    URL: ${request.url}.<br/>
                    RESULT: ${pars.getResult()}<br/>
                    <form method="get">
                        <input name="expr" />
                        <button type="submit">Let's go</button>
                    </form>
                </body>
            </html>
        `);
  } else {
    response.statusCode = '405';
    response.statusMessage = 'Unsupported method';
    response.end();
  }
});

server.listen(PORT, HOST, (err) => {
  if (err) {
    console.log('Error', err);
    return;
  }

  console.log('Server listening on ' + HOST + ':' + PORT);
});
