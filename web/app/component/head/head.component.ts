
import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { User } from "../../model/model";
import { ConstantService } from "../../service/constant.service";
import { TabViewModule } from 'primeng/primeng';

@Component({
    selector: 'head',
    templateUrl: 'app/component/head/head.component.html',
    styleUrls: [
        "public/common/css/head.css"
    ]
}) export class HeadComponent implements OnInit {

    constructor(private route: ActivatedRoute,
                private constantService: ConstantService,
                private router: Router) { }

    //用户状态  当前是否登登录
    private isLogin: boolean = false;

    //当前登录用户
    private currentUser: User;

    //注册用户
    private registerUser: User;



    //初始化加载
    ngOnInit(): void {
        // }
    }  
    
    //获取当前用户
    getCurrentUser(): void {
        this.currentUser = this.constantService.getCurrentUser();
        //当前用户未登录
        if (this.currentUser == null) {
            this.isLogin = false;
        } else {
            //当前有用户登录
            this.isLogin = true;
        }
    }




    //登录提交
    login(): void{
        
    }
    //注册提交
    register(): void{
        
    }

}