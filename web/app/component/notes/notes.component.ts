import { Component, Input, OnInit, ValueProvider, ViewChild, ViewEncapsulation } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Directive, ElementRef, HostBinding, OnChanges, OnDestroy } from '@angular/core';
import {City,Province,Block,Arrraction,Note} from "../../model/model";
import { NOTES } from "../../mock/notes.mock";
import {  Subscription } from "rxjs";
import 'rxjs/add/operator/switchMap';
import{ NoteService }from "../../service/note.service";
import{ ConstantService }from "../../service/constant.service";


@Component({
    encapsulation: ViewEncapsulation.None,
    templateUrl: 'app/component/notes/notes.component.html',
    styleUrls: [
           "public/common/css/notes.css"
    ]
})
export class NotesComponent implements OnInit {

  private noteList : Note[] ;

    constructor(private route: ActivatedRoute,
        private router: Router,
        private noteService:NoteService,
        private constantService:ConstantService,
        private el: ElementRef) {
    }

    //初始化加载
    ngOnInit():void {
        this.loadNotes();
    }

    changeProvince(currentProvince:Province):void{
         this.loadNotes();
    }

    changeCity(currentCity: City):void{
        this.loadNotes();
    }

    loadNotes(){
            let proCode = this.constantService.getCurrentProvince().proCode;
            let cityCode = this.constantService.getCurrentCity().cityCode;
            this.noteService.getNotes(proCode,cityCode).then(
            result => {
                    this.noteList = result;
            }
        )
    }
}



