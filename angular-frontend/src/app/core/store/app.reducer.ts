import { ActionReducerMap } from '@ngrx/store';
import { Auth } from 'src/app/shared/interfaces/auth.interface';
import { authReducer, AuthState } from './auth/auth.reducer';

export interface AppState {
  authState: Auth;
}

export const reducers: ActionReducerMap<AppState> = {
  authState: authReducer,
};
