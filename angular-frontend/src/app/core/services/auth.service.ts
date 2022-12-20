import { Injectable } from '@angular/core';
import { select, Store } from '@ngrx/store';
import { Auth } from 'src/app/shared/interfaces/auth.interface';
import * as AuthActions from '../store/auth/auth.actions';
import { selectAuth } from '../store/auth/auth.selector';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  auth: Auth;

  constructor(private readonly store: Store) {
    store.pipe(select(selectAuth)).subscribe((auth) => {
      if (auth) {
        this.auth = auth;
      }
    });
    setTimeout(() => {
      this.authenticate({
        email: 'kushal@email.com',
        id: 1,
        token: '2akh3h25j2h35j23242efhns',
      });
    }, 5000);
  }

  isAuthenticated(): boolean {
    return !!this.auth && !!this.auth.token;
  }

  authenticate(auth: Auth): void {
    this.store.dispatch(AuthActions.setAuthCredentials(auth));
    this.auth = auth;
  }

  getAuth(): Auth {
    return this.auth;
  }

  logout(): void {
    this.store.dispatch(AuthActions.deleteAuthCredentials());
    this.auth = null;
  }
}