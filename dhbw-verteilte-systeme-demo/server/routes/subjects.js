var express = require("express");
var router = express.Router();

const { v4: uuidv4 } = require("uuid");

var subjects = [
  {
    id: "2a7e31e8-9500-40a6-8c48-78a3d3178d1e",
    subject: "Verteilte Systeme",
  },
  {
    id: "cd0b67e7-e04e-45bd-8f52-aaac2457bd6f",
    subject: "Data Warehouse",
  },
];

/* GET home page. */
router.get("/subjects", function (req, res, next) {
  res.json(subjects);
});

/* get specific subject. */
router.get("/subjects/:id", function (req, res, next) {
  let id = req.params.id;
  let subject = subjects.find((t) => t.id === id);
  res.json(subject);
});

// create new subject
router.post("/subjects", function (req, res, next) {
  let subject = req.body;
  if (subject.subject !== undefined) {
    subjects.push({
      id: uuidv4(),
      ...subject,
    });
    res.json(subjects);
  } else {
    res.status(500).json("Error while adding subject!");
  }
});

// update specific subject
router.put("/subjects", function (req, res, next) {
  let subject = req.body;
  if (subject.subject !== undefined && subject.id !== undefined) {
    subjects = [...subjects.filter((t) => t.id !== subject.id), subject];
    res.json(subjects);
  } else {
    res.status(500).json("Error while updating subject!");
  }
});

// update specific subject
router.delete("/subjects/:id", function (req, res, next) {
  let id = req.params.id;
  if (id !== undefined) {
    subjects = subjects.filter((t) => t.id !== id);
    res.json(subjects);
  } else {
    res.status(500).json("Error while deleting subject!");
  }
});

module.exports = router;
