
import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { User } from "../../model/model";
import { ConstantService } from "../../service/constant.service";
import { UserService } from "../../service/user.service";
import { TabViewModule, PasswordModule, InputTextModule, ButtonModule, EditorModule, SharedModule} from 'primeng/primeng';

@Component({
    selector: 'test',
    templateUrl: 'app/component/ztest/test.component.html',
    // styleUrls: [
    //     "public/common/css/test.css"
    // ]
}) export class TestComponent implements OnInit {

    constructor(private route: ActivatedRoute,
                private constantService: ConstantService,
                private userService: UserService,
                private router: Router) { }

    //用户状态  当前是否登登录
    private isLogin: boolean = false;

    //当前登录用户
    private currentUser: User = new User();

    //登录用户
    private loginUser: User = new User();

    //注册用户
    private registerUser: User = new User();

    private confirmPassword: string = '';

    private text1: string = '';
    private text2: string = '';




    //初始化加载
    ngOnInit(): void {
        this.getCurrentUser();
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

    //弹出登录页面或者注册页面
    inputView(): void{

    }    

    //登录提交
    login(): void{
        this.userService.login(this.loginUser);
        
    }

    //注册提交
    register(): void{
        this.userService.register(this.registerUser);
    }

    //退出
    loginout(): void{
        //清空cookie 刷新当前用户
        this.constantService.clearCurrentUser();
        this.getCurrentUser();
    }

}