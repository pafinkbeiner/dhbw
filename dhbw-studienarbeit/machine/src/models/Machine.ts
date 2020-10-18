export interface Machine{
    // Maschinen Details
    machineDetails: {
        model: string; 
        serialNumber: number;
        sparDistance: number;
    },
    // Allgemein
    operation: {
        power: boolean;
        statusLED: {
            green: boolean;
            yellow: boolean;
            red: boolean;
        },
        running: boolean;
        operationMode: OperationMode
    },    
    // Spritzeinheit
    injectionUnit: {
        position: Position;
        
    },
    // Sicherheitstüre
    savetyDoor: {
        position: Position;
        locked: boolean;
    },
    // Schließeinheit
    lockingUnit: {
        locked: boolean;
        position: Position
    },
    // Material Informationen
    materialInfo :{
        temp: Number,
        material: string;
    },
    // Funktionen
    powerOn: Function;
    resetToDefault: Function;
    setMachineMode: (data: OperationMode) => any;
}

export enum OperationMode{
    automatic,
    semiAutomatic,
    stopped
}

export interface Position{
    x?: number;
    y?: number;
    z?: number;
    min: number;
    max:number;
}