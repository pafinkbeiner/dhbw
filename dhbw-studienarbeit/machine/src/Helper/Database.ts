export class Database{

    db: any = {};

    set(key:string, data: any){
        this.db[key] = data;
    }

    get(key: string): any{
        return this.db[key]
    }

    getAll(){
        return this.db;
    }

}

export class DatabaseHandler{

    private static database: Database;

    private constructor(){}

    public static getDbInstance(): Database{
        if(!DatabaseHandler.database){
            DatabaseHandler.database = new Database();
        }
        return DatabaseHandler.database;
    }
}