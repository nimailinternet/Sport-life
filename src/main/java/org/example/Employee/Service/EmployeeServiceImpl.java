package org.example.Employee.Service;
import org.example.Avatar.Avatar;
import org.example.Avatar.Service.AvatarService;
import org.example.Avatar.dto.request.FindNameAvatarRequest;
import org.example.Employee.Employee;
import org.example.Employee.EmployeeRepository;
import org.example.Employee.dto.request.AuthEmployeeRequest;
import org.example.Employee.dto.request.CreateEmployeeRequest;
import org.example.Employee.dto.response.AuthAndCreateEmployeeResponse;
import org.example.Exceptions.EmployeeFoundException;
import org.example.Exceptions.EmployeeNotFoundException;
import org.example.Exceptions.UnauthorizedEmployeeException;
import org.example.Security.AuthClass;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private  final AuthClass authClass;
    private final AvatarService avatarService;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder, AuthClass authClass, AvatarService avatarService) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
        this.authClass = authClass;
        this.avatarService = avatarService;
    }

    @Override
    public AuthAndCreateEmployeeResponse AuthEmployee(AuthEmployeeRequest dto) {
        Employee employee=employeeRepository
                .findByLogin(dto.getLogin())
                .orElseThrow(()->new EmployeeNotFoundException("",HttpStatus.NOT_FOUND));
        if(!passwordEncoder.matches(employee.getPassword(),dto.getPassword())){
            throw new UnauthorizedEmployeeException("",HttpStatus.UNAUTHORIZED);
        }
        String token=authClass.createToken(dto.getLogin());
        return new AuthAndCreateEmployeeResponse(token);
    }

    @Override
    public AuthAndCreateEmployeeResponse CreateEmployee(CreateEmployeeRequest dto) {
        if(employeeRepository.findByLogin(dto.getLogin()).isPresent()){
            throw new EmployeeFoundException("",HttpStatus.CONFLICT);
        }
        Avatar avatar=avatarService.findAvatar(new FindNameAvatarRequest(dto.getAvatar())).getAvatar();
        String password=passwordEncoder.encode(dto.getPassword());
        Employee employee=new Employee(dto.getLogin(),avatar,password);
        employeeRepository.save(employee);
        String token=authClass.createToken(dto.getLogin());
        return new AuthAndCreateEmployeeResponse(token);
    }
}
