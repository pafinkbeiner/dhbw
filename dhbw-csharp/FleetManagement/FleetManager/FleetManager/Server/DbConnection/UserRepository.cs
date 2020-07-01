using Server.Models;
using System.Linq;

namespace Server.DbConnetion
{
    public class UserRepository : Repository<User>
    {
        public UserRepository(string databaseFile) : base(databaseFile)
        {
        }
        public string GetPasswordHashFromDb(string username)
        {
            string dataPassword;
            using (var session = NHibernateHelper.OpenSession())
            {
                var hashPassword = session.Query<User>()
                    .Where(x => x.Username == username).ToList();
                dataPassword = hashPassword.FirstOrDefault()?.Password;
            }
            return dataPassword;
        }

        public User GetUserFromUsername(string username)
        {
            User user;
            using (var session = NHibernateHelper.OpenSession())
            {
                var userList = session.Query<User>()
                    .Where(x => x.Username == username).ToList();
                user = userList.FirstOrDefault();
            }

            return user;
        }

        private int GetIdFromUsername(string username)
        {
            int userId;
            using (var session = NHibernateHelper.OpenSession())
            {
                var userList = session.Query<User>()
                    .Where(x => x.Username == username).ToList();

                var user = userList.FirstOrDefault();
                if (user == null) return -1;
                userId = user.Id;
            }
            return userId;
        }

        public void SetNewPassword(int userId, string newPasswordHash)
        {
            using (var session = NHibernateHelper.OpenSession())
            {
                using (var transaction = session.BeginTransaction())
                {
                    var userTest = session.Get<User>(userId);
                    userTest.Password = newPasswordHash;
                    session.SaveOrUpdate(userTest);
                    transaction.Commit();
                }
            }
        }
    }
}
