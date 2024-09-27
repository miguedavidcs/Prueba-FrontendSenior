import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Task } from "../app/models/task.model";
@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private JsonUrl ='assets/data/dbprueba.json';
  constructor(private http: HttpClient){}
  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.JsonUrl);
  }


}
