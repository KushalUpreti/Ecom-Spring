import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import * as AuthActions from './auth.actions';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';

import { catchError, EMPTY, switchMap, TimeoutError } from 'rxjs';
import { Auth } from 'src/app/shared/interfaces/auth.interface';

@Injectable()
export class AuthEffects {
  constructor(
    private readonly actions$: Actions,
    private readonly http: HttpClient
  ) {}

  //   fetchAuthCredentials$ = createEffect(() =>
  //     this.actions$.pipe(
  //       ofType(AuthActions.fetchAuthCredentials),
  //       switchMap(() => {
  //         return this.http.post<Auth>(`http://localhost:3000/todos`).pipe(
  //           switchMap((response) => [AuthActions.setAuthCredentials({}),
  //           catchError((err: HttpErrorResponse | TimeoutError) => EMPTY)
  //         );
  //       })
  //     )
  //   );
}