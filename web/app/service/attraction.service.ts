import { Injectable,OnInit } from '@angular/core';
import { Http, Headers, Response, URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {CookieService} from "angular2-cookie/core";
import { Attraction } from "../model/model";
import { TOURIST } from "../mock/tourist.mock";

@Injectable()
export class AttractionService {

    urlPrefix: string = 'itour/attraction';

    constructor(private http: Http) { }

    
    /**
     * 获取景点
     */
    getAttractions(proCode: string, cityCode: string): Promise<Attraction[]>{
        let tmp: Attraction[] = [];
        return Promise.resolve(tmp);
            // let params = new URLSearchParams();
            // let headers = new Headers();
            // headers.set('Accept', 'application/json');

            // params.append('proCode',proCode);
            // params.append('cityCode',cityCode);

            // return this.http.get(`${this.urlPrefix}/getAttractions`, { search: params, headers: headers })
            //     .toPromise()
            //     .then(this.extractData)
            //     .catch(this.handleError);

    }

    /**
     * 
     * 添加景点
     * @private
     * @param {*} error 
     * @returns {Promise<any>} 
     * 
     * @memberOf AttractionService
     */
    addAttractions(attraction:Attraction): Promise<string> {
        let tmp: string = '';
        return Promise.resolve(tmp);
        // let params = new URLSearchParams();
        // let headers = new Headers();
        // headers.set('Accept', 'application/json');

        // params.append('proCode',proCode);
        // params.append('cityCode',cityCode);

        // return this.http.get(`${this.urlPrefix}/getAttractions`, { search: params, headers: headers })
        //     .toPromise()
        //     .then(this.extractData)
        //     .catch(this.handleError);

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