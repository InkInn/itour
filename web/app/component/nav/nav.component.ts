
import { Component,OnInit,Input } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import {Block} from "../../model/model";
import{BLOCK} from "../../mock/block.mock";

@Component({
    selector: 'nav',
    templateUrl: 'app/component/nav/nav.component.html',
    styleUrls: [
        "public/common/css/nav.css"
    ]
})export class NavComponent implements OnInit {

    constructor(private route: ActivatedRoute,private router: Router) {}

    /**
     * 导航
     */
    private blocks: Block[];

    /**
     * 当前导航
     */
    private currentBlock: Block;

    //初始化加载
    ngOnInit():void {
        this.blocks = BLOCK;
        this.currentBlock = this.blocks[0];
    }


    /**
     * 切换导航
     */
    changeBlock(block: Block):void{
        this.currentBlock = block;
        this.goto();
    }

    /**
     * 导航定位
     */
    goto():void{
        if(this.currentBlock){
            //this.router.navigate([this.currentUcomponent.url, { gradeCode: this.currentGrade.code, subjectCode: this.currentSubject.code }]);
            // var url=this.currentUcomponent.url+'/'+this.constantService.getCurrentGrade().code+'/'+this.constantService.getCurrentGrade().code;
            this.router.navigate([this.currentBlock.url]);
        }
    }
}