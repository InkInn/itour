import { Injectable,OnInit } from '@angular/core';
import { Http, Headers, Response, URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {CookieService} from "angular2-cookie/core";
import {Block,Province,City,User} from "../model/model";
import {BLOCK} from "../mock/block.mock";
import {PROVINCE} from "../mock/tour.mock";
import {SHANXI} from "../mock/city.mock";

@Injectable()
export class ConstantService implements OnInit{

    constructor(private cookieService:CookieService){
    };
    /**
     * 模块
     */
    blocks: Block[] = BLOCK;
    /**
     * 选择省份
     */
    provinces: Province[] = [];

    /**
     * 选择城市
     */
    citys: City[] = [];

    /**
     * 当前省份
     */
    currentPro: Province;


    ngOnInit():void {

    }

    public load(list:Province[]):void{
        if(list){
            this.provinces = list;
            this.citys = list[0].cityList;
        }
    }


    /**
     * 当前选择省份
     */
    public getCurrentProvince():Province{
        var provinceCode=this.cookieService.get("currentProCode");
        if(!provinceCode){
            if(this.provinces && this.provinces.length>0){
                this.setCurrentPro(this.provinces[0]);
                this.currentPro = this.provinces[0];
                return this.provinces[0];
            }else{
                return new Province();
            }
        }else{
            if(this.provinces && this.provinces.length>0){
                for(var i=0;i<this.provinces.length;i++){
                    if(provinceCode == this.provinces[i].proCode){
                        this.currentPro = this.provinces[i];
                        return this.provinces[i];
                    }
                }
            }
        }
        return new Province();
    }

    public setCurrentPro(province:Province):void{
        if(Province){
            this.cookieService.put("currentProCode",province.proCode);
        }
    }

    /**
     * 当前选择城市
     */
    public getCurrentCity():City{
        var cityCode=this.cookieService.get("currentCityCode");
        this.citys = this.currentPro.cityList;
        if(!cityCode){
            if(this.citys && this.citys.length>0){
                this.setCurrentCity(this.citys[0]);
                return this.citys[0];
            }else{
                return new City();
            }
        }else{
            if(this.citys && this.citys.length>0){
                for(var i=0;i<this.citys.length;i++){
                    if(cityCode==this.citys[i].cityCode){
                        return this.citys[i];
                    }
                }
            }
        }
        return new City();
    }

    public setCurrentCity(city:City):void{
        if(city){
            this.cookieService.put("currentCityCode",city.cityCode);
        }
    }

    public clearCurrentCity():void{
        this.cookieService.remove("currentCityCode");
    }

    public getCurrentBlock():Block{
        var url=this.cookieService.get("currentBlockUrl");
        if(!url){
            if(this.blocks && this.blocks.length>0){
                this.setCurrentBlock(this.blocks[0]);
                return this.blocks[0];
            }else{
                return new Block();
            }
        }else{
            if(this.blocks && this.blocks.length>0){
                for(var i = 0; i < this.blocks.length; i++){
                    if(url == this.blocks[i].url){
                        return this.blocks[i];
                    }
                }
            }
        }
        return new Block();
    }

    public setCurrentBlock(block: Block):void{
        if(block){
            this.cookieService.put("currentBlockUrl",block.url);
        }
    }


    /**
     * 获取当前用户
     */
    public getCurrentUser(): User {
        let user: User = new User();
        user.userId = this.cookieService.get("currentUserId");
        user.loginName = this.cookieService.get("currentUserLoginName");
        user.password = this.cookieService.get("currentUserPassword");
        return user;
    }
    /**
     * 设置当前用户
     */
    public setCurrentUser(user: User): void {
        if (user) {
            this.cookieService.put("currentUserId", user.userId);
            this.cookieService.put("currentUserLoginName", user.loginName);
            this.cookieService.put("currentUserPassword", user.password);
        }
    }
    /**
     * 
     * 用户退出，清除当前cookie
     */
    public clearCurrentUser(): void{
        this.cookieService.remove("currentUserId");
        this.cookieService.remove("currentUserLoginName");
        this.cookieService.remove("currentUserPassword");
    }
}