using Server.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HostFleetManager.Interfaces
{
    public interface IUserRepository: IRepository<User>
    {
        string GetPasswordHashFromDb(string username);

        User GetUserFromUsername(string username);

        int GetIdFromUsername(string username);

        void SetNewPassword(int userId, string newPasswordHash);

        User GetUserFromId(int id);
    }
}
