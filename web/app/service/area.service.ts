import { Injectable,OnInit } from '@angular/core';
import { Http, Headers, Response, URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {CookieService} from "angular2-cookie/core";
import {Block,Province,City} from "../model/model";
import {BLOCK} from "../mock/block.mock";
import {PROVINCE} from "../mock/tour.mock";
import {SHANXI,ANHUI} from "../mock/city.mock";

@Injectable()
export class AreaService {

    urlPrefix: string = 'itour/area';

    constructor(private http: Http) { }

    
    /**
     * 获取省份
     */
    getProvinces():Promise<Province[]>{
          return Promise.resolve(PROVINCE);
            // let params = new URLSearchParams();
            // let headers = new Headers();
            // headers.set('Accept', 'application/json');

            // return this.http.get(`${this.urlPrefix}/getProvinces`, { search: params, headers: headers })
            //     .toPromise()
            //     .then(this.extractData)
            //     .catch(this.handleError);

    }

    /**
     * 获取城市
     */
    getCitys(proCode:string):Promise<Province>{
        // if(proCode == '01'){
        //     return Promise.resolve(SHANXI);
        // }
        // if(proCode == '02'){
        //     return Promise.resolve(ANHUI);
        // }
            let params = new URLSearchParams();
            let headers = new Headers();
            headers.set('Accept', 'application/json');
           params.append('proCode',proCode);
            return this.http.get(`${this.urlPrefix}/getCitys`, { search: params, headers: headers })
                .toPromise()
                .then(this.extractData)
                .catch(this.handleError);
    }


    //处理错误
    private handleError(error: any): Promise<any> {
        let errorObj = error.json();
        if (errorObj) {
            return Promise.reject(errorObj.errorInfo);
        } else {
            return Promise.reject('请求出错！');
        }
    }

    private extractData(res: Response) {
        let body = res.json();
        if (body.result) {
            return body.result;
        }
        return {};
    }

}