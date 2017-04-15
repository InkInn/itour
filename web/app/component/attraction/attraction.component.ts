import { Component, Input, OnInit, ValueProvider, ViewChild, ViewEncapsulation } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Directive, ElementRef, HostBinding, OnChanges, OnDestroy } from '@angular/core';
import * as echarts from 'echarts';
import * as events from 'events';
import ECharts = echarts.ECharts;
import EChartOption = echarts.EChartOption;
import {City,Province,Block,Attraction} from "../../model/model";
import{ AttractionService }from "../../service/attraction.service";
import{ ConstantService }from "../../service/constant.service";
import { PROVINCE } from "../../mock/tour.mock";
import { BLOCK } from "../../mock/block.mock";
import { TOURIST } from "../../mock/tourist.mock";
import { Subscription } from "rxjs";
import { EditorModule, SharedModule, InputTextModule, ButtonModule } from 'primeng/primeng';
import { } from 'quill';

import 'rxjs/add/operator/switchMap';


@Component({
    encapsulation: ViewEncapsulation.None,
    templateUrl: 'app/component/attraction/attraction.component.html',
    styleUrls: [
        "public/common/css/attract.css"
    ]
})
export class AttractComponent implements OnInit {

    private provinceList : Province[];

    private blockList : Block[] = BLOCK;

    private tourist: Attraction[];
    
    private addAttraction: Attraction = new Attraction();

    private updateAttraction: Attraction = new Attraction();

    private delAttraction: Attraction = new Attraction();
    

    constructor(
        private route: ActivatedRoute,
        private attractionService:AttractionService,
        private constantService: ConstantService,
        private router: Router,
        private el: ElementRef) {
    }

    //初始化加载
    ngOnInit():void {
        this.loadAttraction();
    }

    changeProvince(currentProvince:Province):void{
        this.loadAttraction();
    }

    changeCity(currentCity: City):void{  
        this.loadAttraction();
    }

    add(): void{
        this.attractionService.addAttraction(this.addAttraction,this.constantService.getCurrentProvince().proCode,this.constantService.getCurrentCity().cityCode).then(
            result =>{ 
                this.loadAttraction();
            }
        ); 
    }

    updateView(attraction:Attraction):void {
        this.updateAttraction = attraction;
    }

    update():void{
        this.attractionService.updateAttraction(this.updateAttraction,this.constantService.getCurrentProvince().proCode,this.constantService.getCurrentCity().cityCode).then(
            result =>{ 
                this.loadAttraction();
            }
        ); 
    }

    deleteView(attraction:Attraction):void {
        this.delAttraction = attraction;
    }

    delete():void{
        this.attractionService.delAttraction(this.delAttraction).then(
        result =>{ 
                this.loadAttraction();
        });
    }

    loadAttraction(){
            let proCode = this.constantService.getCurrentProvince().proCode;
            let cityCode = this.constantService.getCurrentCity().cityCode;
            this.attractionService.getAttractions(proCode,cityCode).then(
            result => {
                    this.tourist = result;
            }
        )
    }

}



