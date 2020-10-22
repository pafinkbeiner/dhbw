
export class Log{

    public log(msg: string, obj?: object){

        var logString: string = msg;

        if(msg.search('error') != -1){
            logString = "[ERROR] "+logString;
        }
        if(msg.search('debug') != -1){
            logString = "[DEBUG] "+logString;
        }
        if(msg.search('info') != -1){
            logString = "[INFO] "+logString;
        }

        logString = logString+" at: "+Date.now();
        
        if(obj != undefined){
            console.log(logString, obj);
        }else{
            console.log(logString);
        }
    }

}

export class LogHandler{

    private static Log: Log;

    private constructor(){}

    public static getLogInstance(): Log{
        if(!LogHandler.Log){
            LogHandler.Log = new Log();
        }
        return LogHandler.Log;
    }
}