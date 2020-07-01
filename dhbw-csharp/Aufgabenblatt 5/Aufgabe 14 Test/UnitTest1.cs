using Aufgabe14.Controller;
using Aufgabe14.Interfaces.Infrastructure;
using Aufgabe14.Interfaces.Models;
using Aufgabe14.Models;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;
using System.Collections.Generic;

namespace Aufgabe_14_Test
{
    [TestClass]
    public class UnitTest1
    {
        private const string expectedNameGenre = "TestGenre";
        private const string expectedNameMovie = "TestMovie";

        private Mock<IRepository<IGenre>> genreMockRepository;
        private Mock<IRepository<IMovie>> movieMockRepository;

        private readonly List<IGenre> listOfGenres = new List<IGenre>();
        private readonly List<IMovie> listOfMovies = new List<IMovie>();

        private Mock<IGenre> genreMockValid;
        private Mock<IGenre> genreMockInvalid;
        private Mock<IGenre> genreMockNull;
        private Mock<IMovie> movieMockValid;
        private Mock<IMovie> movieMockInvalid;
        private Mock<IMovie> movieMockNull;

        // GENRE TESTS

        // Add Genre

        [TestMethod]
        public void AddValidGenre()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.SafeDatabase(null, genreMockRepository.Object, genreMockValid.Object);

            Assert.IsTrue(result);
        }

        [TestMethod]
        public void AddInvalidGenre()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.SafeDatabase(null, genreMockRepository.Object, genreMockInvalid.Object);

            Assert.IsFalse(result);
        }

        [TestMethod]
        public void AddNullGenre()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.SafeDatabase(null, genreMockRepository.Object, genreMockNull.Object);

            Assert.IsFalse(result);
        }

        // Remove Genre

        [TestMethod]
        public void RemoveValidGenre()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.DeleteDatabase(null, genreMockRepository.Object, genreMockValid.Object);

            Assert.IsTrue(result);
        }

        [TestMethod]
        public void RemoveInvalidGenre()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.DeleteDatabase(null, genreMockRepository.Object, genreMockInvalid.Object);

            Assert.IsFalse(result);
        }

        [TestMethod]
        public void RemoveNullGenre()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.DeleteDatabase(null, genreMockRepository.Object, genreMockNull.Object);

            Assert.IsFalse(result);
        }

        // MOVIE TESTS

        // Add Movie

        [TestMethod]
        public void AddValidMovie()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.SafeDatabase(movieMockRepository.Object, null, movieMockValid.Object);

            Assert.IsTrue(result);
        }

        [TestMethod]
        public void AddInvalidMovie()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.SafeDatabase(movieMockRepository.Object, null, movieMockInvalid.Object);

            Assert.IsFalse(result);
        }

        [TestMethod]
        public void AddNullMovie()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.SafeDatabase(movieMockRepository.Object, null, movieMockNull.Object);

            Assert.IsFalse(result);
        }

        // Remove Movie

        [TestMethod]
        public void RemoveValidMovie()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.DeleteDatabase(movieMockRepository.Object, null, movieMockValid.Object);

            Assert.IsTrue(result);
        }

        [TestMethod]
        public void RemoveInvalidMovie()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.DeleteDatabase(movieMockRepository.Object, null, movieMockInvalid.Object);

            Assert.IsFalse(result);
        }

        [TestMethod]
        public void RemoveNullMovie()
        {
            InitTest();

            MainWindowController mainWindowController = new MainWindowController();
            mainWindowController.Initialize(movieMockRepository.Object, genreMockRepository.Object, true);
            bool result = mainWindowController.DeleteDatabase(movieMockRepository.Object, null, movieMockNull.Object);

            Assert.IsFalse(result);
        }

        private void InitTest()
        {
            genreMockValid = new Mock<IGenre>();
            genreMockInvalid = new Mock<IGenre>();
            genreMockNull = new Mock<IGenre>();
            movieMockValid = new Mock<IMovie>();
            movieMockInvalid = new Mock<IMovie>();
            movieMockNull = new Mock<IMovie>();
            genreMockRepository = new Mock<IRepository<IGenre>>();
            movieMockRepository = new Mock<IRepository<IMovie>>();
            genreMockValid.SetupGet(g => g.Name).Returns(expectedNameGenre);
            genreMockInvalid.SetupGet(g => g.Name).Returns("");
            genreMockNull.SetupGet(g => g.Name).Returns(null as string);
            movieMockValid.SetupGet(m => m.Titel).Returns(expectedNameMovie);
            movieMockValid.SetupGet(m => m.Genre).Returns(genreMockValid.Object as Genre);
            movieMockInvalid.SetupGet(m => m.Titel).Returns("");
            movieMockInvalid.SetupGet(m => m.Genre).Returns(genreMockInvalid.Object as Genre);
            movieMockNull.SetupGet(m => m.Titel).Returns(null as string);
            movieMockNull.SetupGet(m => m.Genre).Returns(genreMockNull.Object as Genre);

            //Setup

            movieMockRepository.Setup(m => m.Save(movieMockValid.Object)).Returns(() =>
            {
                listOfMovies.Add(movieMockValid.Object);
                return true;
            });
            movieMockRepository.Setup(m => m.Save(movieMockInvalid.Object)).Returns(false);
            movieMockRepository.Setup(m => m.Save(movieMockNull.Object)).Returns(false);
            movieMockRepository.Setup(m => m.Delete(movieMockValid.Object)).Returns(() =>
            {
                listOfMovies.Remove(movieMockValid.Object);
                return true;
            });
            movieMockRepository.Setup(m => m.Delete(movieMockInvalid.Object)).Returns(false);
            movieMockRepository.Setup(m => m.Delete(movieMockNull.Object)).Returns(false);


            genreMockRepository.Setup(gr => gr.Save(genreMockValid.Object)).Returns(() =>
            {
                listOfGenres.Add(genreMockValid.Object);
                return true;
            });
            genreMockRepository.Setup(gr => gr.Save(genreMockInvalid.Object)).Returns(false);
            genreMockRepository.Setup(gr => gr.Save(genreMockNull.Object)).Returns(false);

            genreMockRepository.Setup(gr => gr.Delete(genreMockValid.Object)).Returns(() =>
            {
                listOfGenres.Remove(genreMockValid.Object);
                return true;
            });
            genreMockRepository.Setup(gr => gr.Delete(genreMockInvalid.Object)).Returns(false);
            genreMockRepository.Setup(gr => gr.Delete(genreMockNull.Object)).Returns(false);
        }
    }
}
