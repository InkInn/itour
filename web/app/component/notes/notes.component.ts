import { Component, Input, OnInit, ValueProvider, ViewChild, ViewEncapsulation } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Directive, ElementRef, HostBinding, OnChanges, OnDestroy } from '@angular/core';
import {City,Province,Block,Attraction,Note,User} from "../../model/model";
import { NOTES } from "../../mock/notes.mock";
import {  Subscription } from "rxjs";
import 'rxjs/add/operator/switchMap';
import{ NoteService }from "../../service/note.service";
import{ ConstantService }from "../../service/constant.service";
import{ AttractionService }from "../../service/attraction.service";


@Component({
    encapsulation: ViewEncapsulation.None,
    templateUrl: 'app/component/notes/notes.component.html',
    styleUrls: [
           "public/common/css/notes.css"
    ]
})
export class NotesComponent implements OnInit {

  private noteList : Note[] ;

  private attracList : Attraction[];

  private tmptest: string;

  private addNote:Note = new Note();

  private loginName:string;

  private isLogin:number;

  private currentUser: User  = new User();

    constructor(private route: ActivatedRoute,
        private router: Router,
        private noteService:NoteService,
        private constantService:ConstantService,
        private attractionService:AttractionService,
        private el: ElementRef) {
    }

    //初始化加载
    ngOnInit():void {
        this.loadNotes();
        this.getCurrentUser();
    }

    changeProvince(currentProvince:Province):void{
         this.loadNotes();
    }

    changeCity(currentCity: City):void{
        this.loadNotes();
    }

    add():void{
        let proCode = this.constantService.getCurrentProvince().proCode;
        let cityCode = this.constantService.getCurrentCity().cityCode;
        this.addNote.authorName = this.currentUser.loginName;
        console.log(this.addNote);
        this.noteService.addNote(this.addNote,proCode,cityCode).then(
            result =>{  
                this.loadNotes();
        });
            
    }
    getCurrentUser(): void {
        this.currentUser = this.constantService.getCurrentUser();
        //当前用户未登录
        if (this.currentUser.loginName == null) {
            this.isLogin = 0;
        } else {
            //当前有用户登录
            this.isLogin = 1;
        }
    }
    loginListen():void{
        this. getCurrentUser();
    }
    logoutListen():void{
        this. getCurrentUser();
    }

    clear():void{
        this.addNote.title = '';
        this.addNote.outline = '';
        this.addNote.attCode = '';
    }

    loadNotes(){
            let proCode = this.constantService.getCurrentProvince().proCode;
            let cityCode = this.constantService.getCurrentCity().cityCode;
            this.noteService.getNotes(proCode,cityCode).then(
            result => {
                    this.noteList = result;
            } );
            this.attractionService.getAttractions(proCode,cityCode).then(
            result => {
                    this.attracList = result;
            } );
    }
}



