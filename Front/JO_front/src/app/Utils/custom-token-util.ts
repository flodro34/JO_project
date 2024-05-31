export class CustomTokenUtil {
    private static readonly CHARSET = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    private static readonly TOKEN_LENGTH = 20;
  
    public static generateCustomToken(): string {
      let token = '';
      for (let i = 0; i < this.TOKEN_LENGTH; i++) {
        const randomIndex = Math.floor(Math.random() * this.CHARSET.length);
        token += this.CHARSET[randomIndex];
      }
      return token;
    }
  }