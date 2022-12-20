import { Component } from '@angular/core';
import { Auth } from 'src/app/shared/interfaces/auth.interface';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  constructor(private readonly authService: AuthService) {}

  getAuth(): Auth {
    return this.authService.getAuth();
  }

  isAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }
}
