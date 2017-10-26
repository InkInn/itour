import { Injectable }  from '@angular/core';
import { Router, Resolve, RouterStateSnapshot, ActivatedRouteSnapshot } from '@angular/router';
import {ConstantService} from "./service/constant.service";
import {AreaService} from "./service/area.service";
import {Province} from "./model/model";

@Injectable()
export class AppResolver implements Resolve<Province[]> {
    constructor(private router: Router,private areaService:AreaService,private constantService:ConstantService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<Province[]> {
        return this.areaService.getProvinces().then(list => {
            if (list) {
                this.constantService.load(list);
                return list;
            } else {
                return null;
            }
        });
    }
}
