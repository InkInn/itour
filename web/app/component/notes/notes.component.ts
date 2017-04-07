import { Component, Input, OnInit, ValueProvider, ViewChild, ViewEncapsulation } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Directive, ElementRef, HostBinding, OnChanges, OnDestroy } from '@angular/core';
import {Note} from "../../model/model";
import { NOTES } from "../../mock/notes.mock";
import {  Subscription } from "rxjs";
import 'rxjs/add/operator/switchMap';


@Component({
    encapsulation: ViewEncapsulation.None,
    templateUrl: 'app/component/notes/notes.component.html',
    styleUrls: [
           "public/common/css/notes.css"
    ]
})
export class NotesComponent implements OnInit {

  private noteList : Note[] = NOTES;

    constructor(private route: ActivatedRoute,
        private router: Router,
        private el: ElementRef) {
    }

    //初始化加载
    ngOnInit():void {
     // this.initEcharts();
    }

    //     initEcharts(): void {

    //     this.chart = echarts.init(this.main.nativeElement, 'vintage');
    //     this.chart.setOption(option);
    // }

}



