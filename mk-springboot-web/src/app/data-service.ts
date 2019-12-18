import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {SERVER_API_URL} from "./app.constants";


@Injectable({ providedIn: 'root' })
export class DataService {

    constructor(private http: HttpClient) {}

    testRequest(): Observable<any> {
        return this.http.post(SERVER_API_URL+'/app/mk/home', { observe: 'response' }, {responseType: 'text'});
    }

    CallClick(): any {
        console.log('clicked');
    }

}