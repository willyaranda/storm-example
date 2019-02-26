var express = require('express');
var app = express();
var expressWs = require('express-ws')(app);
const { Person } = require('generate-person');
const superb = require('superb');
const catNames = require('cat-names');
var randomWords = require('random-words');


function generateRandomInteger(min, max) {
    return Math.floor(min + Math.random() * (max + 1 - min))
}

const getYearPublishing = () => {
    return generateRandomInteger(1515, 2019)
}

const getWord = () => {
    return randomWords(1)[0];
}

const getPage = () => {
    return generateRandomInteger(1, 1234)
}

const getBook = () => {
    return `${superb.random()} ${catNames.random()}`;
}

app.get('/', function (req, res, next) {
    res.json({ msg: 'HELLO, REDSYS!!'})
    res.end();
});

app.get('/book/:bookName', function (req, res, next) {
    const person = Person();
    res.json({
        bookName: getBook(),
        authorName: `${person.name} ${person.surname}`,
        bookYear: getYearPublishing()
    })
});

app.get('/author/:authorName', function (req, res, next) {
    res.json(Person())
});

app.ws('/stream', function (ws, req) {
    setInterval(() => {
        ws.send(JSON.stringify({
            word: getWord(),
            page: getPage(),
            book: getBook(),
        }));
    }, 200)
});

const PORT = 8080;
app.listen(PORT);
console.log(`Listening on ${PORT}`)