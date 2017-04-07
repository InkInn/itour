import { Component, OnInit, EventEmitter, Input, Output, Renderer, OnDestroy } from '@angular/core';
import { City, Province } from '../../model/model';
import { PROVINCE } from "../../mock/tour.mock";
import { SHANXI } from "../../mock/city.mock";

@Component({
    selector: 'top',
    templateUrl: 'app/component/top/top.component.html',
})
export class TopComponent implements OnInit, OnDestroy {

    /**
     * 当前选择的省
     */
    private currentProvince: Province;

    /**
     * 当前选择的市
     */
    private currentCity: City;

    /**
     * 省列表
     */
    private provinceList: Province[];

    /**
     * 市列表
     */
    private cityList: City[];

    /**
     * 隐藏省份选择
     */
    private closeProvince: boolean = true;
    /**
     * 展示省份选择
     */
    private openProvince: boolean = false;


    /** 
     * 隐藏城市选择
     */
    private closeCity: boolean = true;

    /**
     * 展示城市选择
     */
    private openCity: boolean = false;

    /**
     * 监听事件
     */
    private documentClickListener: any;


    @Output() changeProvince = new EventEmitter<Province>();
    @Output() changeCity = new EventEmitter<City>();


    constructor(private renderer: Renderer) {
    }

    //初始化加载
    ngOnInit():void {
        //加载当前的省市列表
        this.provinceList = PROVINCE;
        this.cityList = SHANXI;
        this.loadPro();
        this.loadCity();
    }

    ngOnDestroy(): void {
        this.unbindDocumentClickListener();
    }

    loadPro():void{
        this.currentProvince = PROVINCE[0];
    }


    loadCity(): void {
        this.currentCity = SHANXI[0];
    }

    /**
     * 切换省份
     */
    selectPro(province: Province): void{
        //设置当前省份 切换省份
        //this.constantService.setCurrentGrade(grade);
        this.loadPro();
        this.showPro();
        this.changeProvince.emit(this.currentProvince);
    }

    /**
     * 切换城市
     */
    selectCity(city: City): void{
        //设置当前城市 切换城市
        //this.constantService.setCurrentSubject(subject);
        this.loadCity();
        this.showCity();
        this.changeCity.emit(this.currentCity);
    }

    /**
     * 显示省份
     */
    showPro(): void{
        this.closeProvince = false;
        if (!this.openProvince) {
            this.openProvince = true;
            this.bindDocumentClickListener();
        } else {
            this.closeProvince = true;
        }
    }

    /**
     * 显示城市
     */
    showCity(): void{
        this.closeCity = false;
        if (!this.openCity) {
            this.openCity = true;
            this.bindDocumentClickListener();
        } else {
            this.closeCity = true;
        }
    }


    private bindDocumentClickListener() {
        let _this = this;
        if (!this.documentClickListener) {
            this.documentClickListener = this.renderer.listenGlobal('body', 'click', function () {
                if (_this.closeCity) {
                    _this.openCity = false;
                }
                _this.closeCity = true;
                if (_this.closeProvince) {
                    _this.openProvince = false;
                }
                _this.closeProvince = true;
            });
        }
    }

    private unbindDocumentClickListener() {
        if (this.documentClickListener) {
            this.documentClickListener();
        }
    }
}