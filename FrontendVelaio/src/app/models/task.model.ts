import { Usuario } from "../models/usuarios.model";
export interface Task{
  id:number;
  nombre:string;
  fecha_limite:string;
  usuarios:Usuario[]
}
