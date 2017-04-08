import { NgModule } from '@angular/core';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { PaginatorModule } from 'primeng/primeng';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './appRouting.module';
import {NavComponent} from "./component/nav/nav.component";
import {TopComponent} from "./component/top/top.component";
import {AttractComponent} from "./component/attraction/attraction.component";
import {NotesComponent} from "./component/notes/notes.component";
import {AreaService} from "./service/area.service";
import {ConstantService} from "./service/constant.service";
import {CookieService} from "angular2-cookie/core";



@NgModule({
    imports: [BrowserModule, FormsModule, HttpModule,PaginatorModule,CommonModule,AppRoutingModule],
    declarations: [AppComponent,AttractComponent,NotesComponent,NavComponent,TopComponent],
    providers: [{ provide: LocationStrategy, useClass: HashLocationStrategy},AreaService,CookieService,ConstantService],
    bootstrap: [AppComponent]
})
export class AppModule {
}