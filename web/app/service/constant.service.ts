import { Injectable,OnInit } from '@angular/core';
import { Http, Headers, Response, URLSearchParams } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {CookieService} from "angular2-cookie/core";
import {Block,Province,City} from "../model/model";
import {BLOCK} from "../mock/block.mock";
import {PROVINCE} from "../mock/tour.mock";
import {SHANXI} from "../mock/city.mock";

@Injectable()
export class ConstantService implements OnInit{

    constructor(private cookieService:CookieService){
    };
    /**
     * 模块
     */
    blocks: Block[] = BLOCK;
    /**
     * 选择省份
     */
    provinces: Province[] = [];

    /**
     * 选择城市
     */
    citys: City[] = [];


    ngOnInit():void {

    }

    // public load(userGradeSubject:UserGradeSubject):void{
    //     if(userGradeSubject){
    //         this.grades=userGradeSubject.grades;
    //         this.subjects=userGradeSubject.subjects;
    //         this.school=userGradeSubject.school;
    //     }
    // }


    // /**
    //  * 当前选择年级
    //  */
    // public getCurrentProvince():Grade{
    //     var gradeCode=this.cookieService.get("currentGradeCode");
    //     if(!gradeCode){
    //         if(this.grades && this.grades.length>0){
    //             this.setCurrentGrade(this.grades[0]);
    //             return this.grades[0];
    //         }else{
    //             return new Grade();
    //         }
    //     }else{
    //         if(this.grades && this.grades.length>0){
    //             for(var i=0;i<this.grades.length;i++){
    //                 if(gradeCode==this.grades[i].code){
    //                     return this.grades[i];
    //                 }
    //             }
    //         }
    //     }
    //     return new Grade();
    // }

    // public setCurrentGrade(grade:Grade):void{
    //     if(grade){
    //         this.cookieService.put("currentGradeCode",grade.code);
    //     }
    // }

    // /**
    //  * 当前选择学科
    //  */
    // public getCurrentSubject():Subject{
    //     var subjectCode=this.cookieService.get("currentSubjectCode");
    //     if(!subjectCode){
    //         if(this.subjects && this.subjects.length>0){
    //             this.setCurrentSubject(this.subjects[0]);
    //             return this.subjects[0];
    //         }else{
    //             return new Subject();
    //         }
    //     }else{
    //         if(this.subjects && this.subjects.length>0){
    //             for(var i=0;i<this.subjects.length;i++){
    //                 if(subjectCode==this.subjects[i].code){
    //                     return this.subjects[i];
    //                 }
    //             }
    //         }
    //     }
    //     return new Subject();
    // }

    // public setCurrentSubject(subject:Subject):void{
    //     if(subject){
    //         this.cookieService.put("currentSubjectCode",subject.code);
    //     }
    // }

    public getCurrentBlock():Block{
        var url=this.cookieService.get("currentBlockUrl");
        if(!url){
            if(this.blocks && this.blocks.length>0){
                this.setCurrentBlock(this.blocks[0]);
                return this.blocks[0];
            }else{
                return new Block();
            }
        }else{
            if(this.blocks && this.blocks.length>0){
                for(var i = 0; i < this.blocks.length; i++){
                    if(url == this.blocks[i].url){
                        return this.blocks[i];
                    }
                }
            }
        }
        return new Block();
    }

    public setCurrentBlock(block: Block):void{
        if(block){
            this.cookieService.put("currentBlockUrl",block.url);
        }
    }
}