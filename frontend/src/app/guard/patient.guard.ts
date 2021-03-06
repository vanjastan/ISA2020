import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {UserService} from 'src/app/services/user.service';

@Injectable()
export class PatientGuard implements CanActivate {
    constructor(private router: Router, private userService: UserService) {
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        if (this.userService.currentUser) {
          if (JSON.stringify(this.userService.currentUser.authorities).search('ROLE_PATIENT') !== -1) {
            return true;
          } else {
            this.router.navigate(['/403']);
            return false;
          }
    
        } else {
          this.router.navigate(['/login'], {queryParams: {returnUrl: state.url}});
          return false;
        }
      }
}