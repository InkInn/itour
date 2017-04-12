import { Injectable, OnInit } from '@angular/core';
import { Http, Headers, Response, URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { CookieService } from "angular2-cookie/core";
import { User } from "../model/model";

@Injectable()
export class UserService {

    urlPrefix: string = 'itour/user';

    constructor(private http: Http) { }


    /**
     * 用户登录
     */
    login(user:User): Promise<string> {
        let params = new URLSearchParams();
        let headers = new Headers();
        headers.set('Accept', 'application/json');

        params.append('loginName', user.loginName);
        params.append('password', user.password);

        return this.http.get(`${this.urlPrefix}/login`, { search: params, headers: headers })
            .toPromise()
            .then(this.extractData)
            .catch(this.handleError);

    }

    /**
     * 用户注册
     */
    register(user: User): Promise<string> {
        let params = new URLSearchParams();
        let headers = new Headers();
        headers.set('Accept', 'application/json');

        params.append('loginName', user.loginName);
        params.append('password', user.password);

        return this.http.get(`${this.urlPrefix}/register`, { search: params, headers: headers })
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