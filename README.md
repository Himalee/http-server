[![Build Status](https://travis-ci.com/Himalee/http-server.svg?branch=master)](https://travis-ci.com/Himalee/http-server)
[![Coverage Status](https://coveralls.io/repos/github/Himalee/http-server/badge.svg?branch=master)](https://coveralls.io/github/Himalee/http-server?branch=master)

# HTTP Server

This is a HTTP server built to pass these [specifications](https://github.com/8thlight/apprenticeship_syllabus/blob/master/crafter/code_projects/http_server_part_1.md).
[Deployed](https://mysterious-retreat-84427.herokuapp.com/) using Heroku. 

#### How it works

1. Server listens on a port for connections.
2. When a HTTP request is made to the correct port, the connection is accepted, establishing a communication channel between the client and server (an input stream from client to server and an output stream from server to client).
3. The request is read from the input stream and parsed. 
4. The request gets routed to the correct `Handler` and a HTTP response is built.
5. The response is written to the output stream.
6. The socket is closed.
7. The server continues to listen for connections.

#### Prerequisites

1. Install [Java (11.0.2)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

#### Running instructions

1. Clone the repository.
2. In your terminal, navigate into the repository.
3. Run shell script by running `$ . ./set_up.sh`
4. Build the app, and run the unit tests by running `$ ./gradlew clean build`.
5. Start the server by running `$ ./gradlew run`.
6. Kill the server with `$ ctrl-c`.

#### Run acceptance tests

1. Start the server by running `$ ./gradlew run`.
2. In a new terminal window navigate to file which contains the acceptance tests by running `$ cd src/test/http_server_spec`.
3. Install [Bundler](https://bundler.io/), and then run `$ bundle install` to clone dependencies.
4. Whilst the server is running, run `$ bundle exec spinach` to run the acceptance tests.
5. To kill the server, navigate back to terminal window that is running the server and `$ ctrl-c`.
