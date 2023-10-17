
interface Inventory{
    StockLevelUsed: string,
    StockLevelNew: string
}
export enum Condition{

    NEW,
    VERY_GOOD,

    GOOD
}
export enum Genre{
    Action,
    Platform,
    First_Person_shooter,
    Adventure,
    Real_time_strategy,
    Simulation
}
export enum Platform{
     WII,
    PS5,
    WINDOWS,


}
export interface Games{
    id?: string,
    name?: string,
    description?: string,
    genre?: Genre,
    platform?: Platform,
    rating?: number,
    price?: number,
    released?: Date,
    condition?: Condition,
    inventory?: Inventory,
    publisher?: Publisher,
    image?: string,


}
export interface Publisher{
    id: string,
    name: string,
    game: Games[]
}