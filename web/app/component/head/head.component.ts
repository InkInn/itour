
import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { User } from "../../model/model";
import { ConstantService } from "../../service/constant.service";
import { UserService } from "../../service/user.service";
import { TabViewModule, PasswordModule, InputTextModule, ButtonModule} from 'primeng/primeng';

@Component({
    selector: 'batten',
    templateUrl: 'app/component/head/head.component.html',
    styleUrls: [
        "public/common/css/head.css"
    ]
}) export class HeadComponent implements OnInit {

    constructor(private route: ActivatedRoute,
                private constantService: ConstantService,
                private userService: UserService,
                private router: Router) { }

    //用户状态  当前是否登登录 0:未登录，1:登录
    private isLogin: number = 0;

    //当前登录用户
    private currentUser: User = new User();

    //登录用户
    private loginUser: User = new User();

    //注册用户
    private registerUser: User = new User();

    private confirmPassword: string = '';



    //初始化加载
    ngOnInit(): void {
        this.getCurrentUser();
    }  
    
    //获取当前用户
    getCurrentUser(): void {
        this.currentUser = this.constantService.getCurrentUser();
        //当前用户未登录
        if (this.currentUser.loginName == null) {
            this.isLogin = 0;
        } else {
            //当前有用户登录
            this.isLogin = 1;
        }
    }



    //登录提交
    login(): void{
        //this.userService.login(this.loginUser);
        this.currentUser.loginName ="21312";
           this.isLogin = 1;
        
    }

    //注册提交
    register(): void{
        //this.userService.register(this.registerUser);
    }

    //退出
    loginout(): void{
        //清空cookie 刷新当前用户
        // this.constantService.clearCurrentUser();
        // this.getCurrentUser();
        this.isLogin = 0;
    }

}