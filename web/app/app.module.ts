import { NgModule } from '@angular/core';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { PaginatorModule } from 'primeng/primeng';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './appRouting.module';
import { NavComponent } from "./component/nav/nav.component";
import { HeadComponent } from "./component/head/head.component";
import {TopComponent} from "./component/top/top.component";
import {AttractComponent} from "./component/attraction/attraction.component";
import { NotesComponent } from "./component/notes/notes.component";
import { TestComponent } from "./component/ztest/test.component";
import {AreaService} from "./service/area.service";
import {ConstantService} from "./service/constant.service";
import {AttractionService} from "./service/attraction.service";
import { NoteService } from "./service/note.service";
import { UserService } from "./service/user.service";
import {CookieService} from "angular2-cookie/core";
import { AppResolver } from "./app.resolver";
import { TabViewModule, PasswordModule, ButtonModule, InputTextModule,EditorModule, SharedModule} from 'primeng/primeng';



@NgModule({
    imports: [BrowserModule, FormsModule, HttpModule, PaginatorModule, CommonModule, AppRoutingModule, ButtonModule, TabViewModule, PasswordModule, EditorModule, SharedModule],
    declarations: [AppComponent, AttractComponent, NotesComponent, NavComponent, TopComponent, HeadComponent, TestComponent],
    providers: [{ provide: LocationStrategy, useClass: HashLocationStrategy }, NoteService, AttractionService, AreaService,UserService,CookieService,ConstantService,AppResolver],
    bootstrap: [AppComponent]
})
export class AppModule {
}