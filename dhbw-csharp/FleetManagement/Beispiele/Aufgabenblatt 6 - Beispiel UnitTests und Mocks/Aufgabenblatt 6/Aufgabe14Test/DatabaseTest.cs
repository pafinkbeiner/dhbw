using System;
using Aufgabe_14.Frameworks;
using Aufgabe_14.Interfaces;
using Aufgabe_14.Models;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;

namespace Aufgabe14Test
{
    [TestClass]
    public class DatabaseTest
    {
        private Mock<IRepository<Movie>> movieRepoMock = new Mock<IRepository<Movie>>();
        private Mock<IRepository<Genre>> genreRepoMock = new Mock<IRepository<Genre>>();
        private Movie movieNull = null;
        private Movie movieValid = new Movie {Id = 1, Genre = new Genre {Id = 1, Name = "Anime"}, Title = "Your Name"};
        private Movie movieInvalid = new Movie {Id = 1, Genre = new Genre {Id = 1, Name = null}, Title = "Your Name"};
        private Genre genreNull = null;
        private Genre genreValid = new Genre {Id = 1, Name = "Anime"};
        private Genre genreInvalid = new Genre {Id = 1, Name = null};

        [TestMethod]
        public void UploadNullToMovieRepository()
        {
            movieRepoMock.Setup(x => x.Save(null)).Returns(false);

            Assert.IsFalse(movieRepoMock.Object.Save(movieNull));
        }

        [TestMethod]
        public void UploadValidMovieToMovieRepository()
        {
            movieRepoMock.Setup(x => x.Save(movieValid)).Returns(true);

            Assert.IsTrue(movieRepoMock.Object.Save(movieValid));
        }

        [TestMethod]
        public void UploadInvalidMovieToMovieRepository()
        {
            movieRepoMock.Setup(x => x.Save(movieInvalid)).Returns(false);

            Assert.IsFalse(movieRepoMock.Object.Save(movieInvalid));
        }

        [TestMethod]
        public void UploadNullToGenreRepository()
        {
            genreRepoMock.Setup(x => x.Save(null)).Returns(false);

            Assert.IsFalse(genreRepoMock.Object.Save(genreNull));
        }

        [TestMethod]
        public void UploadValidGenreToGenreRepository()
        {
            genreRepoMock.Setup(x => x.Save(genreValid)).Returns(true);
            
            Assert.IsTrue(genreRepoMock.Object.Save(genreValid));
        }

        [TestMethod]
        public void UploadInvalidGenreToGenreRepository()
        {
            genreRepoMock.Setup(x => x.Save(genreInvalid)).Returns(false);

            Assert.IsFalse(genreRepoMock.Object.Save(genreInvalid));
        }

        [TestMethod]
        public void DeleteNullFromMovieRepository()
        {
            movieRepoMock.Setup(x => x.Delete(null)).Returns(false);

            Assert.IsFalse(movieRepoMock.Object.Delete(movieNull));
        }

        [TestMethod]
        public void DeleteValidMovieFromMovieRepository()
        {
            movieRepoMock.Setup(x => x.Delete(movieValid)).Returns(true);

            Assert.IsTrue(movieRepoMock.Object.Delete(movieValid));
        }

        [TestMethod]
        public void DeleteInvalidMovieFromMovieRepository()
        {
            movieRepoMock.Setup(x => x.Delete(movieInvalid)).Returns(false);

            Assert.IsFalse(movieRepoMock.Object.Delete(movieInvalid));
        }

        [TestMethod]
        public void DeleteNullFromGenreRepository()
        {
            genreRepoMock.Setup(x => x.Delete(null)).Returns(false);

            Assert.IsFalse(genreRepoMock.Object.Delete(genreNull));
        }

        [TestMethod]
        public void DeleteValidGenreFromGenreRepository()
        {
            genreRepoMock.Setup(x => x.Delete(genreValid)).Returns(true);

            Assert.IsTrue(genreRepoMock.Object.Delete(genreValid));
        }

        [TestMethod]
        public void DeleteInvalidGenreFromGenreRepository()
        {
            genreRepoMock.Setup(x => x.Delete(genreInvalid)).Returns(false);

            Assert.IsFalse(genreRepoMock.Object.Delete(genreInvalid));
        }
    }
}
