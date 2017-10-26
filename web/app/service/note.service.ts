import { Injectable,OnInit } from '@angular/core';
import { Http, Headers, Response, URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {CookieService} from "angular2-cookie/core";
import {Note} from "../model/model";

@Injectable()
export class NoteService {

    urlPrefix: string = 'itour/note';

    constructor(private http: Http) { }

    
    /**
     * 获取游记
     */
    getNotes(proCode:string,cityCode:string):Promise<Note[]>{
            let params = new URLSearchParams();
            let headers = new Headers();
            headers.set('Accept', 'application/json');

            params.append('proCode',proCode);
            params.append('cityCode',cityCode);

            return this.http.get(`${this.urlPrefix}/getNotes`, { search: params, headers: headers })
                .toPromise()
                .then(this.extractData)
                .catch(this.handleError);

    }

    /**
     * 添加游记
     */
    addNote(note:Note,proCode:string,cityCode:string):Promise<Note[]>{
            let params = new URLSearchParams();
            let headers = new Headers();
            headers.set('Accept', 'application/json');

            params.append('title',note.title);
            params.append('outline',note.outline);
            params.append('authorName',note.authorName);
            params.append('attCode',note.attCode);
            params.append('proCode',proCode);
            params.append('cityCode',cityCode);

            return this.http.get(`${this.urlPrefix}/addNote`, { search: params, headers: headers })
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