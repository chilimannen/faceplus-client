package com.rduda.Controller;

/**
 * Created by Robin on 2015-11-27.
 * <p>
 * Provides the default image.
 */
class ImageStore {

    public static byte[] getPlaceholder() {
        return placeholder.getBytes();
    }

    private static final String placeholder =
            "iVBORw0KGgoAAAANSUhEUgAAANQAAADICAYAAACQys/4AAAACXBIWXMAAAsTAAALEwEAmpwYAAAK" +
                    "T2lDQ1BQaG90b3Nob3AgSUNDIHByb2ZpbGUAAHjanVNnVFPpFj333vRCS4iAlEtvUhUIIFJCi4AU" +
                    "kSYqIQkQSoghodkVUcERRUUEG8igiAOOjoCMFVEsDIoK2AfkIaKOg6OIisr74Xuja9a89+bN/rXX" +
                    "Pues852zzwfACAyWSDNRNYAMqUIeEeCDx8TG4eQuQIEKJHAAEAizZCFz/SMBAPh+PDwrIsAHvgAB" +
                    "eNMLCADATZvAMByH/w/qQplcAYCEAcB0kThLCIAUAEB6jkKmAEBGAYCdmCZTAKAEAGDLY2LjAFAt" +
                    "AGAnf+bTAICd+Jl7AQBblCEVAaCRACATZYhEAGg7AKzPVopFAFgwABRmS8Q5ANgtADBJV2ZIALC3" +
                    "AMDOEAuyAAgMADBRiIUpAAR7AGDIIyN4AISZABRG8lc88SuuEOcqAAB4mbI8uSQ5RYFbCC1xB1dX" +
                    "Lh4ozkkXKxQ2YQJhmkAuwnmZGTKBNA/g88wAAKCRFRHgg/P9eM4Ors7ONo62Dl8t6r8G/yJiYuP+" +
                    "5c+rcEAAAOF0ftH+LC+zGoA7BoBt/qIl7gRoXgugdfeLZrIPQLUAoOnaV/Nw+H48PEWhkLnZ2eXk" +
                    "5NhKxEJbYcpXff5nwl/AV/1s+X48/Pf14L7iJIEyXYFHBPjgwsz0TKUcz5IJhGLc5o9H/LcL//wd" +
                    "0yLESWK5WCoU41EScY5EmozzMqUiiUKSKcUl0v9k4t8s+wM+3zUAsGo+AXuRLahdYwP2SycQWHTA" +
                    "4vcAAPK7b8HUKAgDgGiD4c93/+8//UegJQCAZkmScQAAXkQkLlTKsz/HCAAARKCBKrBBG/TBGCzA" +
                    "BhzBBdzBC/xgNoRCJMTCQhBCCmSAHHJgKayCQiiGzbAdKmAv1EAdNMBRaIaTcA4uwlW4Dj1wD/ph" +
                    "CJ7BKLyBCQRByAgTYSHaiAFiilgjjggXmYX4IcFIBBKLJCDJiBRRIkuRNUgxUopUIFVIHfI9cgI5" +
                    "h1xGupE7yAAygvyGvEcxlIGyUT3UDLVDuag3GoRGogvQZHQxmo8WoJvQcrQaPYw2oefQq2gP2o8+" +
                    "Q8cwwOgYBzPEbDAuxsNCsTgsCZNjy7EirAyrxhqwVqwDu4n1Y8+xdwQSgUXACTYEd0IgYR5BSFhM" +
                    "WE7YSKggHCQ0EdoJNwkDhFHCJyKTqEu0JroR+cQYYjIxh1hILCPWEo8TLxB7iEPENyQSiUMyJ7mQ" +
                    "AkmxpFTSEtJG0m5SI+ksqZs0SBojk8naZGuyBzmULCAryIXkneTD5DPkG+Qh8lsKnWJAcaT4U+Io" +
                    "UspqShnlEOU05QZlmDJBVaOaUt2ooVQRNY9aQq2htlKvUYeoEzR1mjnNgxZJS6WtopXTGmgXaPdp" +
                    "r+h0uhHdlR5Ol9BX0svpR+iX6AP0dwwNhhWDx4hnKBmbGAcYZxl3GK+YTKYZ04sZx1QwNzHrmOeZ" +
                    "D5lvVVgqtip8FZHKCpVKlSaVGyovVKmqpqreqgtV81XLVI+pXlN9rkZVM1PjqQnUlqtVqp1Q61Mb" +
                    "U2epO6iHqmeob1Q/pH5Z/YkGWcNMw09DpFGgsV/jvMYgC2MZs3gsIWsNq4Z1gTXEJrHN2Xx2KruY" +
                    "/R27iz2qqaE5QzNKM1ezUvOUZj8H45hx+Jx0TgnnKKeX836K3hTvKeIpG6Y0TLkxZVxrqpaXllir" +
                    "SKtRq0frvTau7aedpr1Fu1n7gQ5Bx0onXCdHZ4/OBZ3nU9lT3acKpxZNPTr1ri6qa6UbobtEd79u" +
                    "p+6Ynr5egJ5Mb6feeb3n+hx9L/1U/W36p/VHDFgGswwkBtsMzhg8xTVxbzwdL8fb8VFDXcNAQ6Vh" +
                    "lWGX4YSRudE8o9VGjUYPjGnGXOMk423GbcajJgYmISZLTepN7ppSTbmmKaY7TDtMx83MzaLN1pk1" +
                    "mz0x1zLnm+eb15vft2BaeFostqi2uGVJsuRaplnutrxuhVo5WaVYVVpds0atna0l1rutu6cRp7lO" +
                    "k06rntZnw7Dxtsm2qbcZsOXYBtuutm22fWFnYhdnt8Wuw+6TvZN9un2N/T0HDYfZDqsdWh1+c7Ry" +
                    "FDpWOt6azpzuP33F9JbpL2dYzxDP2DPjthPLKcRpnVOb00dnF2e5c4PziIuJS4LLLpc+Lpsbxt3I" +
                    "veRKdPVxXeF60vWdm7Obwu2o26/uNu5p7ofcn8w0nymeWTNz0MPIQ+BR5dE/C5+VMGvfrH5PQ0+B" +
                    "Z7XnIy9jL5FXrdewt6V3qvdh7xc+9j5yn+M+4zw33jLeWV/MN8C3yLfLT8Nvnl+F30N/I/9k/3r/" +
                    "0QCngCUBZwOJgUGBWwL7+Hp8Ib+OPzrbZfay2e1BjKC5QRVBj4KtguXBrSFoyOyQrSH355jOkc5p" +
                    "DoVQfujW0Adh5mGLw34MJ4WHhVeGP45wiFga0TGXNXfR3ENz30T6RJZE3ptnMU85ry1KNSo+qi5q" +
                    "PNo3ujS6P8YuZlnM1VidWElsSxw5LiquNm5svt/87fOH4p3iC+N7F5gvyF1weaHOwvSFpxapLhIs" +
                    "OpZATIhOOJTwQRAqqBaMJfITdyWOCnnCHcJnIi/RNtGI2ENcKh5O8kgqTXqS7JG8NXkkxTOlLOW5" +
                    "hCepkLxMDUzdmzqeFpp2IG0yPTq9MYOSkZBxQqohTZO2Z+pn5mZ2y6xlhbL+xW6Lty8elQfJa7OQ" +
                    "rAVZLQq2QqboVFoo1yoHsmdlV2a/zYnKOZarnivN7cyzytuQN5zvn//tEsIS4ZK2pYZLVy0dWOa9" +
                    "rGo5sjxxedsK4xUFK4ZWBqw8uIq2Km3VT6vtV5eufr0mek1rgV7ByoLBtQFr6wtVCuWFfevc1+1d" +
                    "T1gvWd+1YfqGnRs+FYmKrhTbF5cVf9go3HjlG4dvyr+Z3JS0qavEuWTPZtJm6ebeLZ5bDpaql+aX" +
                    "Dm4N2dq0Dd9WtO319kXbL5fNKNu7g7ZDuaO/PLi8ZafJzs07P1SkVPRU+lQ27tLdtWHX+G7R7ht7" +
                    "vPY07NXbW7z3/T7JvttVAVVN1WbVZftJ+7P3P66Jqun4lvttXa1ObXHtxwPSA/0HIw6217nU1R3S" +
                    "PVRSj9Yr60cOxx++/p3vdy0NNg1VjZzG4iNwRHnk6fcJ3/ceDTradox7rOEH0x92HWcdL2pCmvKa" +
                    "RptTmvtbYlu6T8w+0dbq3nr8R9sfD5w0PFl5SvNUyWna6YLTk2fyz4ydlZ19fi753GDborZ752PO" +
                    "32oPb++6EHTh0kX/i+c7vDvOXPK4dPKy2+UTV7hXmq86X23qdOo8/pPTT8e7nLuarrlca7nuer21" +
                    "e2b36RueN87d9L158Rb/1tWeOT3dvfN6b/fF9/XfFt1+cif9zsu72Xcn7q28T7xf9EDtQdlD3YfV" +
                    "P1v+3Njv3H9qwHeg89HcR/cGhYPP/pH1jw9DBY+Zj8uGDYbrnjg+OTniP3L96fynQ89kzyaeF/6i" +
                    "/suuFxYvfvjV69fO0ZjRoZfyl5O/bXyl/erA6xmv28bCxh6+yXgzMV70VvvtwXfcdx3vo98PT+R8" +
                    "IH8o/2j5sfVT0Kf7kxmTk/8EA5jz/GMzLdsAAAAgY0hSTQAAeiUAAICDAAD5/wAAgOkAAHUwAADq" +
                    "YAAAOpgAABdvkl/FRgAADtNJREFUeNrsnX9wnHWdx9+f7242Sdu0qFBLW5EWHD0Cxe4+m/Ri5Fqu" +
                    "llakU+AaRG4cKJwcTM9R6nA4HHOH41zHG8dDhwPnKCPij5GIqFQR5DACJaT7PLubaoPnNS6gIHfy" +
                    "KySFpJvd53N/NDKFJM3u5tns5vm+X392IO33/fm89vv5Pvs8T0RVQQgJBsMICKFQhFAoQigUIaRk" +
                    "hBHUnoGBgdjhw4dXGGOWG2OWqmoUwBJV9UVkBMC47/t/UtUXIpHIc47jjDO1+uHYC3sUqgbyjI6O" +
                    "tgH4kKq2iciZAFYDiJb4IwoAcqp6UERSItLb1NS0v7W1Nc90KZQtEi0aHR29WEQuUNVNAFoC/isO" +
                    "A3hEVfdGo9EfrF27doipU6jQkclkzlbVXap6EYCFc/TXHgFwv6p+OZlMplgFCjXv8TyvE8DnAWyp" +
                    "Zcaq+piI/FsikXhARPgNPoWaX6RSqQ5jzJcAdNbZP+0ggF2O4/ycVaJQdU82mz2hWCzuBvAp1PdX" +
                    "Ed3GmM/G4/E/smoUqi5Jp9OXqOotAJbNk3/yCICbcrncrV1dXUVWkELVBQcOHFiYz+fvFJFL5ukS" +
                    "Hi4Wi5e2t7e/zGpSqJriuu5qEfkhgDXzfCnPisjFiUQizaoGIxRvPSoTz/M2iYgbApkA4L2qus91" +
                    "3R2sbDBQqPLOS1cAeADAO0O0rCYRudPzvBtYYQo1l2PeDlXdAyAS0iXu9jzvJlaaQs3FmHeViOyx" +
                    "IK8vpNPpL7LiFKqaO9OVAP4TllzAUdUbPc/7J1a+MniV7/hnpnNV9SGUfid4iLzSrmQyeS+7oKSw" +
                    "KNRM7N+/f1UkEtkP4CRLI3jD9/0PtbW19bMbKNRsz0wLADyJcFwanw3PGWPi8Xj8RXZFaULxDDU1" +
                    "d1EmAMBK3/e7VZUfvCVCoSafm/4WwHYm8SbrM5nMtYyhNPjJcwypVGqZMWYA4friNggOF4vFNe3t" +
                    "7U8zCo58pW/XxtxGmaZkUSQSuZOjH0e+cka9LgAXMolp2ZDJZP6OMXDkm5He3t7mWCx2CMAKpnFc" +
                    "XgBwuuM4bzAKjnzT0tjYuJMylcTJqvpZxsAdalr6+voWR6PRHIB3sR1K4rV8Pr+6o6PjFUbBHWoS" +
                    "0Wh0F2UqiyWxWOzzjIE71CQ8zzsRQA7Bv3gy7IxGIpHlfKEmd6i3B7GDMlVEc6FQuIIxTMZYLJMR" +
                    "kavZAhWONiLX8HspCnXsuHcejr6kn1TG+9Lp9EcYA4U6unBj/p7lnzW8x+/tO7eNi06lUu8xxjyN" +
                    "8L4fYq4Yz+fzy2y/hG79RQljzIWUKRAaGhoazmcMlo98InIBSx8Y2xiBxSOf53lLALwIoIHlD4TD" +
                    "+Xx+aUdHxyhHPgt3KBHZTJkCZVFjY+NGxmCpUKq6lWUPFt/3z2MK9p6hzmXZA9/11zEFC4Xq6+tb" +
                    "ifnze5zmE2f19PQ0MQbLhGpoaGhjyatCbOHChXHGYJlQqppkyavUSMYwWwvPUNyhmC2FChCOJdXj" +
                    "dEZgkVDZbPYEACew5FVjFSOwSCjf909huavKSb29vc0UyhJU9T3s+erS2Nh4KoWyBwpV/SmAQlm0" +
                    "Vo581W4mY1ZSKHtYypav+g7VSKHsoZktX11EZBGFsqjebPmqC8UdyqK1LmbLVxdVbaJQhATHQgrF" +
                    "YpPgiFIoe8aRIvu96rxGoew5ML/Kfq96xiMUyh6G2PJVnwIoFIUi3KEoFEe+OsT3fQpl0ThCoapM" +
                    "JBIZolD27FD/x5avLsVi8WkKZU+xc2z56kYsIn+gUJaQz+d/x56vKs85jjNOoSyhs7NzBMCf2PdV" +
                    "42lGYNm9fCIyyJJXjWcYgX03x3Lsqx48o8K+N8dyh6re7s+Rz8KRjztUlfB9/3+YgmVCFYtFFr1K" +
                    "0YrIQcZgmVCFQuEggALLHjiDjuO8wRgsE2ri98D+lmUPnF8zAguFAgBVzbLsgWfazxQsFUpEWHzu" +
                    "UBQqsAUbQ6ECJhqN/oopWCrU+Pg4hQqWl9euXfsMY7BUqPb29pcB/J6lD4x9jMBioSbOUb0sfWA8" +
                    "xggsF8r3/V+y9IGdSSmU7UKxCQJjeHBwkF9DHDv92Lpwz/NeALCMLVA5qvpgMpncwhzU7h1q4hzF" +
                    "sW/2GXKn58jHc1SAGf4XU6BQf4ZCzY4/JJNJjzFQKABAMpn8LYBDbIGK+ZGIKGOgUMdyH1ug4vPT" +
                    "j5gChXr7GeAHbIGKeGV4eJgXJCjUpLHPA/As26Bs7t+wYQMf1KRQk8YWFRGOfeXnxswoFMe+gHh+" +
                    "eHj4Z4yBQk2J4zhPgnefl4yq7uG4R6GON774AG5nK5REoVgs7mEMFGom9gA4whhm/PB5YN26dc8x" +
                    "CQo109j3EoB7mMSM582vMwUKVeqnL8e+4zPoOM5DjIFClUQikegDkGYSU6OquyfOm4RClcxXGMGU" +
                    "PLtgwYJvMwYKVe4u9T0Av2ESk/hia2trnjFQqHLPUb6qfoFJvIWnRkZG7mIMJfYQI5h0VpB0Ot0H" +
                    "oI1pACKyNZFI7GUSx+0Z7lDHaSA1xnwGAJ/1AX5CmTjyzZp4PP6kiNh+CH/dGLOT3UChgtrGr4PF" +
                    "vzVeVW+Kx+N8tIVCBYPjOC+JyKctlekRx3FuYRdQqEBJJBL3ALjbsmW/VCwWL+f7IihUVWhoaLgW" +
                    "wH9bstyiqn6CN8BSqKpx9tlnvy4iFwF4zYLl3pBMJh9m1SlUtUe/30xIFeYH6253HOfLrDaFmiup" +
                    "fqGqOwAUw7Y2Vd2by+X+gVWePbxTokxc171SRO4IU3bGmNZ4PP4Uq1vxBxKFmg2e5x0AsCYky0k7" +
                    "juOwqsEIxZGvMgZCtJZ7WU6eoWpNaB7x4K/1oVD1sMU/E5KlvKGqfEqZQtX8EP98iM5P46wohaop" +
                    "hUIhLHcS5FhNClVzIpHIKyFZyiCrSaHqgVCMSarKV1BTqNqTSCRGQnIWHGM1KRQJbod6nSlQqJrT" +
                    "39+/mCkQChUQxWIxFEKpajOrSaHqgRPDsAgROYWlpFD10IjvC8lSKBSFqgvOCsk6TmUpKVTN8X0/" +
                    "LI9u/KWq8hEeClU7enp6mkRkfUiWszSbza5hVSlUzWhpadkMoCVEu+3HWVUKVTNU9eKQLeny3t5e" +
                    "Xj6nUHNPf3//ChHZHrJlLYvFYlexuhRqzikUCv8MoDGES7u5r6/v3awwhZoz0un0hwGE9ZP8HQ0N" +
                    "Dd/o7u6OsNIUqur09fWtVNXvIcRviVLVLatXr/53XkafHQxvBlKp1DJjzC8A/IUlS74jl8td09XV" +
                    "VWT1S/4wolAlytRqjNkLYJVlDfKIiHzccZyX2AXlCcWRbxpc191ijHnCNpkAQET+GoDneV6cncAz" +
                    "VBAy7RSRvQCWWBzDewE84bruJ9kRPENVxMDAQGxsbOxrqno103jLjnWrql7HV47xDFUy/f39KwqF" +
                    "wr0A1jGNKdnn+/72tra2/2UUFGqmEW+9iNwDYCnTOC7PG2O2x+PxJxkFL0pMoru7O+K67o0i8jBl" +
                    "KokVvu/3eJ53LaPgGeoteJ53mojcraodbIOKzlX3i8hV8Xj8Re5QFu9QqirpdPpTALKUaVY5bvV9" +
                    "/9eu636UaVi6Q7muu1ZEbuOFh6Dd0rsikcg/2rpbWXdRIpPJnOT7/s0Arga/e6sWQwBuTCQSXxcR" +
                    "n0KF85x0MoDPTYi0kD0/J/QDuDmRSPxYRJRChUOkswBcC+ByAE3s8ZpwEMDuXC53T9hvtA2lUPv2" +
                    "7Wtpbm6+VFWvBNDGfq4bfg/gmwC+6TjO7yhUHbN///53RaPRrQC2qeom7kZ1f/HicQB3q+pPw3TH" +
                    "xbwVSlVNNpuN+76/EcAmAOcA4FOm87AHJ85aPzHG/GxwcDA1n8fCeSVUNps9tVAonCciGwGcC+Cd" +
                    "7MfQ8SqAXgBPiMi+4eFhd8OGDWMUKgB6enqaWlpazhGRzaq6BcAH2G/WcURE0qr6mIg8Ojo6+kRn" +
                    "Z+cIhSoRz/OWiEiXqm4DsB7AAvYUOYYCgLSIPOr7/qNHjhx5vJ4Eqwuhuru7I6tWrToPwCdFZCsA" +
                    "vmyRlCNYj4h8X1V/WOtH9WsqlOu6q40xO1X1MvAObxKQXAC68/n8fR0dHa9YIVQqlfqgMeZ6ANsB" +
                    "RNkHpBpnL1X9biQS+Wo8Hj8QSqEymcw5qnqDqm4GH2gkc8cvAXw1kUjcX+17C+dEKM/zTgFwC4AL" +
                    "WVtSQ54SkV2JROLBeSnUoUOHGoeGhj4nIjfyQgOpF1T1wUgksisejz81b4RKp9PrVPVbAE5nCUkd" +
                    "UgBwWz6fv6Gjo2O0boVSVfE87zMi8iUADawbqXMOquqlyWTyYN0Jlc1mTygWi98AsI11IvOIMQDX" +
                    "OY5ze90INXHh4ecA3s/6kHl6tvoPx3E+PZsrgYEI5XneaQAewdFX9hIyn/kOgCsqfTPurN96lMlk" +
                    "zgDwOGUiIeEyAPcNDAzEZvuDyhaqr6/v3b7vPwTgZNaBhIiPjY2N3T6nQvX09DRFo9EfA1jJ/EkI" +
                    "z1M7XNe9fs6EWrRo0R0A2hk9CSsi8q/pdHpzxf9/qf+h67qXish3GTmxgD/GYrEz16xZ82qJO1t5" +
                    "O9SBAweWisjXmDOxhOX5fP4rVRv5xsfHbwVwInMmFnG567obAxfK87xOHH2GiRDb2K2qEqhQAHYz" +
                    "V2IjIuJ4nndRYEK5rrsFQCejJRZL9S/l7FJmhh92PSMllnNmJpPZNGuhJm4vWs88ie2o6jWzFsr3" +
                    "/Z2MkhAAwAXZbPbUioXq6elpwtEbBgkhgCkUCpdVLNTixYu3AFjMHAk5iohcUrFQqvoJRkjIWzhr" +
                    "4hf5lSdUb29vM4DzmR8hkzaai8sWKhaLnQu+/ouQqca+rZWMfNydCJmatRPvUaFQhATEtpKFmvgy" +
                    "9xRmRsi0nF+yUBO/+JkQMj1/NTAwsKjUkY9CEXJ8GkdHRzfOKNShQ4caVXU98yKk8rHvTaGGhoY+" +
                    "DF4uJ6QUPjrdIx1vCiUim5kTISWxPJPJxGc6Q/FyOSEloqp/M61Qruu+H8AHGBMhJbN9WqGMMVuZ" +
                    "DyFlcVoqlUpOKRTvLiekfIwxO97+Z5JKpVqNMQcZDyFlM9Lc3Lz8jDPOOPznP/j/AQBk32Dbp82D" +
                    "MQAAAABJRU5ErkJggg==";
}


