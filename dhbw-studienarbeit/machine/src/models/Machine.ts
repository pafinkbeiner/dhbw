export interface Machine{
    // Maschinen Details
    mashineDetails: {
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
    // Funktionen
    powerOn: Function;
    resetToDefault: Function;
    closeSafetyDoor: Function;
    openSafetyDoor: Function;
}

export enum OperationMode{
    automatic,
    semiAutomatic
}

export interface Position{
    x?: number;
    y?: number;
    z?: number;
    min: number;
    max:number;
}