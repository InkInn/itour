import { NgModule } from '@angular/core';
import { RouterModule, PreloadAllModules } from '@angular/router';
import {AttractComponent} from "./component/attraction/attraction.component";
import {NotesComponent} from "./component/notes/notes.component";



@NgModule({
    imports: [
        RouterModule.forRoot(
            [
                { path: '',
                    resolve: {
                        // userGradeSubject: AppResolver
                    },
                   /* redirectTo: '/teachingEmphasis',
                    pathMatch: 'full',*/
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