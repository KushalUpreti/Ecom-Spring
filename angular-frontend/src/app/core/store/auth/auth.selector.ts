import { authFeatureKey, AuthState } from './auth.reducer';
import { createFeatureSelector, createSelector } from '@ngrx/store';

export const selectAuthState = createFeatureSelector<AuthState>(authFeatureKey);

export const selectAuth = createSelector(
  selectAuthState,
  (state: AuthState) => state && state.auth
);
