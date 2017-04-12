
import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Block } from "../../model/model";
import { BLOCK } from "../../mock/block.mock";

@Component({
    selector: 'nav',
    templateUrl: 'app/component/head/head.component.html',
    styleUrls: [
        "public/common/css/head.css"
    ]
}) export class HeadComponent implements OnInit {

    constructor(private route: ActivatedRoute, private router: Router) { }



    //初始化加载
    ngOnInit(): void {
        // }
    }    
}