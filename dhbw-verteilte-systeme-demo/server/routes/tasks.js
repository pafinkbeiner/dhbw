var express = require("express");
var router = express.Router();

const { v4: uuidv4 } = require("uuid");

var tasks = [
  {
    id: "8b893817-4205-42a3-9a17-9b1832cf4991",
    timestamp: 1618396014571,
    name: "VL 5",
    description: "Vorlesungsvideo 5 anschauen",
    expirationDate: 1618531200000,
    subject: "Data Warehouse",
    done: false,
  },
  {
    id: "c319c528-9e59-4556-ba43-1b9d6386ebd1",
    timestamp: 1618396035855,
    name: "VL5 Aufgaben",
    description: "Aufgaben zur Vorlesung 5 bearbeiten",
    expirationDate: 1618704000000,
    subject: "Data Warehouse",
    done: false,
  },
  {
    id: "7c5e75b6-c7ca-4611-abd8-b542c5a534c7",
    name: "Demo ",
    timestamp: 1618396056578,
    description: "Demo Projekt zur Server-Client Architektur erstellen",
    expirationDate: 1618358400000,
    subject: "Verteilte Systeme",
    done: false,
  },
];

/* GET home page. */
router.get("/tasks", function (req, res, next) {
  res.json(tasks);
});

/* get specific task. */
router.get("/tasks/:id", function (req, res, next) {
  let id = req.params.id;
  let task = tasks.find((t) => t.id === id);
  res.json(task);
});

// create new task
router.post("/tasks", function (req, res, next) {
  let task = req.body;
  if (
    task.done !== undefined &&
    task.name !== undefined &&
    task.description !== undefined &&
    task.expirationDate !== undefined
  ) {
    tasks.push({
      id: uuidv4(),
      timestamp: Date.now(),
      ...task,
    });
    res.json(tasks);
  } else {
    res.status(500).json("Error while adding task!");
  }
});

// update specific task
router.put("/tasks", function (req, res, next) {
  let task = req.body;
  if (
    task.done !== undefined &&
    task.name !== undefined &&
    task.description !== undefined &&
    task.id !== undefined &&
    task.timestamp !== undefined &&
    task.expirationDate !== undefined
  ) {
    tasks = [...tasks.filter((t) => t.id !== task.id), task];
    res.json(tasks);
  } else {
    res.status(500).json("Error while updating task!");
  }
});

// update specific task
router.delete("/tasks/:id", function (req, res, next) {
  let id = req.params.id;
  if (id !== undefined) {
    tasks = tasks.filter((t) => t.id !== id);
    res.json(tasks);
  } else {
    res.status(500).json("Error while deleting task!");
  }
});

module.exports = router;
