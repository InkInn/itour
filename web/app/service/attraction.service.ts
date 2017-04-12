import { Injectable,OnInit } from '@angular/core';
import { Http, Headers, Response, URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {CookieService} from "angular2-cookie/core";
import { Arrraction } from "../model/model";
import { TOURIST } from "../mock/tourist.mock";

@Injectable()
export class AttractionService {

    urlPrefix: string = 'itour/attraction';

    constructor(private http: Http) { }

    
    /**
     * 获取景点
     */
    getAttractions(proCode: string, cityCode: string): Promise<Arrraction[]>{
        let tmp: Arrraction[] = [];
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