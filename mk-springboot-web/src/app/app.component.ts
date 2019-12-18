import { Component } from '@angular/core';
import {DataService} from "./data-service";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})

export class AppComponent {
    name = 'Spring Boot Angular Sample Application';

    constructor(private testSer: DataService ) {}

    myInsert() {
        this.testSer.testRequest().subscribe(
            response => console.log('Success Response',response),
            err => console.log('Failure Response,',err)
        );
    }
}