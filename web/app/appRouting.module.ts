import { NgModule } from '@angular/core';
import { RouterModule, PreloadAllModules } from '@angular/router';
import {AttractComponent} from "./component/attraction/attraction.component";
import { NotesComponent } from "./component/notes/notes.component";
import { TestComponent } from "./component/ztest/test.component";
import {AppResolver} from "./app.resolver";



@NgModule({
    imports: [
        RouterModule.forRoot(
            [
                { path: '',
                    resolve: {
                         list: AppResolver
                    },
                    children: [
                        {path: '',redirectTo: '/attract',pathMatch: 'full'},
                        { path: 'attract', component: AttractComponent},
                        { path: 'notes', component: NotesComponent},
                    ]},

            ]
        )
    ],
    exports: [RouterModule]
})
export class AppRoutingModule { }