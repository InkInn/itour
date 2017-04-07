// /**
//  * Created by hushenzhu-pc on 2017/3/8.
//  */
// import { Injectable }  from '@angular/core';
// import { Router, Resolve, RouterStateSnapshot,
//     ActivatedRouteSnapshot } from '@angular/router';
// import {CommonService} from "./service/common.service";
// import {ConstantService} from "./service/constant.service";
// import {UserGradeSubject} from "./model/userGradeSubject";
// @Injectable()
// export class AppResolver implements Resolve<UserGradeSubject> {
//     constructor(private router: Router,private commonService:CommonService,private constantService:ConstantService) {}

//     resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<UserGradeSubject> {
//         return this.commonService.getUserGradeSubject().then(userGradeSubject => {
//             if (userGradeSubject) {
//                 this.constantService.load(userGradeSubject);
//                // this.router.navigate(['/']);
//                 return userGradeSubject;
//             } else {
//                 return null;
//             }
//         });
//     }
// }
