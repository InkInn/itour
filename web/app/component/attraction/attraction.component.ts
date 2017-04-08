import { Component, Input, OnInit, ValueProvider, ViewChild, ViewEncapsulation } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Directive, ElementRef, HostBinding, OnChanges, OnDestroy } from '@angular/core';
import * as echarts from 'echarts';
import * as events from 'events';
import ECharts = echarts.ECharts;
import EChartOption = echarts.EChartOption;
import {City,Province,Block,Tourist} from "../../model/model";
import { PROVINCE } from "../../mock/tour.mock";
import { BLOCK } from "../../mock/block.mock";
import { TOURIST } from "../../mock/tourist.mock";
import {  Subscription } from "rxjs";
import 'rxjs/add/operator/switchMap';


@Component({
    encapsulation: ViewEncapsulation.None,
    templateUrl: 'app/component/attraction/attraction.component.html',
    styleUrls: [
        "public/common/css/attract.css"
    ]
})
export class AttractComponent implements OnInit {

    private provinceList : Province[] = PROVINCE;

    private blockList : Block[] = BLOCK;

    private Tourist : Tourist[] = TOURIST;

    constructor(
        private route: ActivatedRoute,
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
    changeProvince(currentProvince:Province):void{

    }

    changeCity(currentCity: City):void{
        
    }

}



